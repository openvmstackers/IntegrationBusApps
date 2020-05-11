<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
  
  <xsl:template match="/">
  	<xsl:variable name="var1">
  		<xsl:apply-templates mode="pass1"/>
  	</xsl:variable>
  	<xsl:variable name="var2">
  		<xsl:apply-templates mode="pass2" select="$var1"/>
  	</xsl:variable>
  	<xsl:copy-of select="$var2"/>
  </xsl:template>
  
  
 <xsl:template match="/Envelope/Body/RetrieveInformationResponse" mode="pass1">
 	<xsl:element name="records">
 		<xsl:for-each select="./record">
	 		<xsl:element name="record">
	 			<xsl:for-each select="column">
	 				<xsl:element name="{./name}"><xsl:value-of select="./value"/></xsl:element>
	 			</xsl:for-each>
			</xsl:element>
 		</xsl:for-each>
 	</xsl:element>
 </xsl:template>
 
<xsl:template match="records" mode="pass2">
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
</xsl:template>

</xsl:stylesheet>

