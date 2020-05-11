<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
  
 
 <xsl:template match="/">
 	<xsl:element name="records">
	 	<xsl:for-each select="SOAP_Domain_Msg/Body/RetrieveInformationResponse/record">
	 		<xsl:element name="record">
	 			<xsl:for-each select="column">
	 				<xsl:element name="{./name}"><xsl:value-of select="./value"/></xsl:element>
	 			</xsl:for-each>
			</xsl:element>
	 	</xsl:for-each>
 	</xsl:element>
 </xsl:template>
 
</xsl:stylesheet>