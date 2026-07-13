package org.hl7.fhir.utilities.xhtml;

import org.hl7.fhir.utilities.xml.XMLWriter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class CDANarrativeFormatTest {

	@ParameterizedTest
	@CsvSource(textBlock = """
		# Blank input
		<div></div>,<?xml version="1.0" encoding="UTF-8"?><text/>
		# Ensure we don't introduce any regressions to the parent class's behaviour
		<div>Plain text</div>,<?xml version="1.0" encoding="UTF-8"?><text>Plain text</text>
		<div><table><thead><tr><th>Header</th></tr></thead><tbody><tr><td>Body row</td></tr></tbody><tfoot><tr><td>Footer</td></tr></tfoot></table></div>,<?xml version="1.0" encoding="UTF-8"?><text><table><thead><tr><th>Header</th></tr></thead><tbody><tr><td>Body row</td></tr></tbody><tfoot><tr><td>Footer</td></tr></tfoot></table></text>
		<div><h2>Plain text</h2></div>,<?xml version="1.0" encoding="UTF-8"?><text><caption>Plain text</caption></text>
		<div><h2>Plain text</h2><table><thead><tr><th>Header</th></tr></thead><tbody><tr><td>Body row</td></tr></tbody></table></div>,<?xml version="1.0" encoding="UTF-8"?><text><caption>Plain text</caption><table><thead><tr><th>Header</th></tr></thead><tbody><tr><td>Body row</td></tr></tbody></table></text>
		<div>One line<br/>Another line</div>,<?xml version="1.0" encoding="UTF-8"?><text>One line<br/>Another line</text>
		<div><colgroup><col>Plain text</col></colgroup></div>,<?xml version="1.0" encoding="UTF-8"?><text><colgroup><col>Plain text</col></colgroup></text>
		<div><span>Plain text</span></div>,<?xml version="1.0" encoding="UTF-8"?><text><content>Plain text</content></text>
		<div><ul><li>Plain text</li></ul></div>,<?xml version="1.0" encoding="UTF-8"?><text><list listType="unordered"><item>Plain text</item></list></text>
		<div><ol><li>Plain text</li></ol></div>,<?xml version="1.0" encoding="UTF-8"?><text><list listType="ordered"><item>Plain text</item></list></text>
		<div><p>Plain text</p></div>,<?xml version="1.0" encoding="UTF-8"?><text><paragraph>Plain text</paragraph></text>
		<div><img src="image.png"/></div>,<?xml version="1.0" encoding="UTF-8"?><text><renderMultiMedia referencedObject="image.png"/></text>
		<div><sub>Plain text</sub></div>,<?xml version="1.0" encoding="UTF-8"?><text><sub>Plain text</sub></text>
		<div><sup>Plain text</sup></div>,<?xml version="1.0" encoding="UTF-8"?><text><sup>Plain text</sup></text>
		<div><a id="id" href="link.html"/></div>,<?xml version="1.0" encoding="UTF-8"?><text><linkHtml ID="id" referencedObject="link.html"/></text>
		# Add support for <div> elements
		<div><div>Plain text</div></div>,<?xml version="1.0" encoding="UTF-8"?><text><content>Plain text</content></text>
		# Add support for other header levels
		<div><h1>Plain text</h1></div>,<?xml version="1.0" encoding="UTF-8"?><text><caption>Plain text</caption></text>
		<div><h3>Plain text</h3></div>,<?xml version="1.0" encoding="UTF-8"?><text><caption>Plain text</caption></text>
		<div><h4>Plain text</h4></div>,<?xml version="1.0" encoding="UTF-8"?><text><caption>Plain text</caption></text>
		<div><h5>Plain text</h5></div>,<?xml version="1.0" encoding="UTF-8"?><text><caption>Plain text</caption></text>
		<div><h6>Plain text</h6></div>,<?xml version="1.0" encoding="UTF-8"?><text><caption>Plain text</caption></text>
		# pass through CDA Narrative elements unchanged
		<div><renderMultiMedia referencedObject="image.png"/></div>,<?xml version="1.0" encoding="UTF-8"?><text><renderMultiMedia referencedObject="image.png"/></text>
		<div><paragraph>Plain text</paragraph></div>,<?xml version="1.0" encoding="UTF-8"?><text><paragraph>Plain text</paragraph></text>
		<div><list listType="unordered"><item>Plain text</item></list></div>,<?xml version="1.0" encoding="UTF-8"?><text><list listType="unordered"><item>Plain text</item></list></text>
		<div><list listType="ordered"><item>Plain text</item></list></div>,<?xml version="1.0" encoding="UTF-8"?><text><list listType="ordered"><item>Plain text</item></list></text>
		<div><content>Plain text</content></div>,<?xml version="1.0" encoding="UTF-8"?><text><content>Plain text</content></text>
		<div>Text with a footnote.<footnoteRef IDREF="fn1"/><footnote ID="fn1">This is the footnote</footnote></div>,<?xml version="1.0" encoding="UTF-8"?><text>Text with a footnote.<footnoteRef IDREF="fn1"/><footnote ID="fn1">This is the footnote</footnote></text>
		# strip unsupported tags but retain the contents
		<div><b>Plain text</b></div>,<?xml version="1.0" encoding="UTF-8"?><text>Plain text</text>
		<div><i>Plain text</i></div>,<?xml version="1.0" encoding="UTF-8"?><text>Plain text</text>
		<div><notxhtml>Plain text</notxhtml></div>,<?xml version="1.0" encoding="UTF-8"?><text>Plain text</text>
		<div><empty/></div>,<?xml version="1.0" encoding="UTF-8"?><text/>
		# case insensitivity
		<div><UL><LI>Plain text</LI></UL></div>,<?xml version="1.0" encoding="UTF-8"?><text><list listType="unordered"><item>Plain text</item></list></text>
		""")
	void testConvert(String theInputXhtml, String theExpectedNarrative) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLWriter xmlWriter = new XMLWriter(out, "UTF-8");
		xmlWriter.start();

		XhtmlNode node = new XhtmlNode();
		node.setValueAsString(theInputXhtml);

		CDANarrativeFormat converter = new CDANarrativeFormat();
		converter.convert(xmlWriter, node);

		xmlWriter.close();
		String actualNarrative = out.toString(StandardCharsets.UTF_8);
		assertThat(actualNarrative).isEqualTo(theExpectedNarrative);

	}
}
