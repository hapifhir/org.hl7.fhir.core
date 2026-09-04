package org.hl7.fhir.r5.igs.testing.renderers;

import org.hl7.fhir.r5.renderers.RendererFactory;

/**
 * Registration companion for the hand-written renderers of the FHIR Testing IG
 * (hl7.fhir.uv.testing). This is the rendering-layer counterpart to the generated
 * {@code org.hl7.fhir.r5.igs.testing.TestingRegistration} facade: where that registers the
 * parsers/composers, this registers the renderers.
 * <p/>
 * The two are deliberately kept separate. Parser registration is global by default (with an
 * optional scoped registry) because parsers are constructed in many places that cannot pass a
 * registry; renderer registration is per {@link RendererFactory} instance, so an application
 * registers the renderers on the factory it hands to its {@code RenderingContext}. Keeping this
 * companion in the renderer package (rather than on the parser facade) also means the parsing
 * layer never has to depend on the rendering layer. See additional-resources-r5.md.
 */
public class TestingRenderers {

  /**
   * Register the Testing IG renderers on the given factory. A registered renderer takes
   * precedence over the built-in renderer (and the profile-driven fallback) for the same
   * resource name, so the IG version of {@code TestPlan} is rendered in place of the base one.
   *
   * @param rendererFactory the factory the application hands to its RenderingContext
   */
  public static void register(RendererFactory rendererFactory) {
    rendererFactory.registerRenderer("TestPlan", TestPlanRenderer.class);
  }

}
