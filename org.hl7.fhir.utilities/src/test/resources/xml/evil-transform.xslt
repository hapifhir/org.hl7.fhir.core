<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        Evil: <xsl:value-of select="document('jackpot.xml')" />
    </xsl:template>
</xsl:stylesheet>