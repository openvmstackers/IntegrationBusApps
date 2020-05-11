<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/records">
			<xsl:element name="records">
				<xsl:for-each select="record">
					<xsl:sort select="SSORTDATE" order="descending" data-type="number"/>
						<xsl:copy-of select="."/>
				</xsl:for-each>
			</xsl:element>
	</xsl:template>

</xsl:stylesheet>
