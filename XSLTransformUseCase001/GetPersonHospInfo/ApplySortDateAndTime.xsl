<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/">
		<xsl:for-each select="records">
			<xsl:element name="records">
				<xsl:for-each select="record">
					<xsl:element name="record">
						<xsl:for-each select="*">
							<xsl:copy-of select="."/>
						</xsl:for-each>
						<xsl:choose>
							<xsl:when test="HCAPTUREDATE">
								<xsl:element name="SSORTDATE"><xsl:value-of select="HCAPTUREDATE"/></xsl:element>
							</xsl:when>
							<xsl:when test="HHOSPDATE">
								<xsl:element name="SSORTDATE"><xsl:value-of select="HHOSPDATE"/></xsl:element>
							</xsl:when>
							<xsl:otherwise>
								<xsl:element name="SSORTDATE">0</xsl:element>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:element>
				</xsl:for-each>
			</xsl:element>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>
