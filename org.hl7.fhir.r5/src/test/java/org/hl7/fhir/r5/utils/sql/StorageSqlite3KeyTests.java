package org.hl7.fhir.r5.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.utils.UserDataNames;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the key-resolution behaviour of
 * {@link StorageSqlite3#getKeyForSourceResource} and
 * {@link StorageSqlite3#getKeyForTargetResource}. These methods do not touch
 * the SQLite connection, so the storage is constructed with a {@code null}
 * connection for these tests.
 *
 * @author John Grimes
 */
class StorageSqlite3KeyTests {

  /**
   * Confirms that when the IG publisher has stamped a primary-key value via
   * UserDataNames.db_key, the source-resource key resolver returns that value
   * as a string so that view-result keys can join against the Resources table.
   */
  @Test
  void sourceKey_usesDbKey_whenPresent() {
    StorageSqlite3 storage = new StorageSqlite3(null);
    Patient patient = new Patient();
    patient.setUserData(UserDataNames.db_key, 42);

    assertEquals("42", storage.getKeyForSourceResource(patient));
  }

  /**
   * Confirms that the target-resource key resolver behaves identically to the
   * source-resource resolver when a db_key is present.
   */
  @Test
  void targetKey_usesDbKey_whenPresent() {
    StorageSqlite3 storage = new StorageSqlite3(null);
    Patient patient = new Patient();
    patient.setUserData(UserDataNames.db_key, 17);

    assertEquals("17", storage.getKeyForTargetResource(patient));
  }

  /**
   * When no db_key has been stamped (for example, when the resolver is invoked
   * outside the IG publisher), the source-resource resolver should fall back
   * to the canonical type/id form used by the other Storage implementations.
   */
  @Test
  void sourceKey_fallsBack_toTypeSlashId() {
    StorageSqlite3 storage = new StorageSqlite3(null);
    Patient patient = new Patient();
    patient.setId("abc");

    assertEquals("Patient/abc", storage.getKeyForSourceResource(patient));
  }

  /**
   * Same fallback behaviour expected for the target-resource resolver.
   */
  @Test
  void targetKey_fallsBack_toTypeSlashId() {
    StorageSqlite3 storage = new StorageSqlite3(null);
    Patient patient = new Patient();
    patient.setId("abc");

    assertEquals("Patient/abc", storage.getKeyForTargetResource(patient));
  }

  /**
   * Guards against treating a value of zero as if the db_key were absent. A
   * legitimate key of 0 must be preserved by the resolver.
   */
  @Test
  void sourceKey_zeroDbKey_isReturnedAsString() {
    StorageSqlite3 storage = new StorageSqlite3(null);
    Patient patient = new Patient();
    patient.setUserData(UserDataNames.db_key, 0);

    assertEquals("0", storage.getKeyForSourceResource(patient));
  }

  /**
   * Documents the existing fallback behaviour when a resource has neither a
   * db_key nor an id - the resolver returns "Type/null", matching StorageJson
   * and TestStorage.
   */
  @Test
  void sourceKey_fallback_whenIdMissing() {
    StorageSqlite3 storage = new StorageSqlite3(null);
    Patient patient = new Patient();

    assertEquals("Patient/null", storage.getKeyForSourceResource(patient));
  }

  /**
   * A null resource is allowed (Runner translates this into a clean
   * FHIRException). The resolver should return null without throwing.
   */
  @Test
  void sourceKey_nullResource_returnsNull() {
    StorageSqlite3 storage = new StorageSqlite3(null);

    assertNull(storage.getKeyForSourceResource(null));
  }

  /**
   * Companion null-handling check for the target-resource resolver.
   */
  @Test
  void targetKey_nullResource_returnsNull() {
    StorageSqlite3 storage = new StorageSqlite3(null);

    assertNull(storage.getKeyForTargetResource(null));
  }
}
