{{startMark}}
package {{pid}};

{{license}}

{{generated}}
public class Constants {

  public static final String PACKAGE_NAME = "{{package-name}}";
  public static final String VERSION_MAJOR_MINOR = {{version-mm-expr}};
  public static final String VERSION_MAJOR_MINOR_PATCH = {{version-mmp-expr}};
  public static final String VERSION = {{version-expr}};
  public static final String VERSION_BASE = VERSION_MAJOR_MINOR_PATCH;
  public static final String VERSION_MM = VERSION_MAJOR_MINOR;
  public final static String DATE = "{{date}}";
}