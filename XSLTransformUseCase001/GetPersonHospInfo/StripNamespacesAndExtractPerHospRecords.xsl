<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="comment()">
	    <xsl:copy>
	      <xsl:variable name="vPass1">
	      	<xsl:apply-templates/>
	      </xsl:variable>
	      <xsl:variable name="vPass2">
	      	<xsl:apply-templates mode="pass2" select="$vPass1/*"/>
	      </xsl:variable>
	      <xsl:copy-of select="$vPass1"/>
	    </xsl:copy>
	  </xsl:template>
	
	  <xsl:template match="*">
	    <!-- remove element prefix -->
	    <xsl:element name="{local-name()}">
	      <!-- process attributes -->
	      <xsl:for-each select="@*">
	        <!-- remove attribute prefix -->
	        <xsl:attribute name="{local-name()}">
	          <xsl:value-of select="."/>
	        </xsl:attribute>
	      </xsl:for-each>
	      <xsl:apply-templates/>
	    </xsl:element>
	  </xsl:template>
	  
	  <xsl:template match="*/RetrieveInformationResponse" mode="pass2">
	 	<xsl:element name="records">
		 	<xsl:for-each select="/record">
		 		<xsl:element name="record">
		 			<xsl:for-each select="column">
		 				<xsl:element name="{./name}"><xsl:value-of select="./value"/></xsl:element>
		 			</xsl:for-each>
				</xsl:element>
		 	</xsl:for-each>
	 	</xsl:element>
	 </xsl:template>

</xsl:stylesheet>
