<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
		xmlns:d="http://docbook.org/ns/docbook"
 version="1.0">
  <xsl:import href="titlepage.xsl" />
  <xsl:import href="docbook-xsl-1.79.2/fo/docbook.xsl" />  

  <xsl:param name="paper.type" select="'A4'"/>
  <xsl:param name="page.margin.bottom" select="'2.5cm'"/>
  <xsl:param name="page.margin.top" select="'1.5cm'"/>
  <xsl:param name="page.margin.inner" select="'2cm'"/>
  <xsl:param name="page.margin.outer" select="'2cm'"/>
  <xsl:param name="region.before.extent" select="'2cm'" />
  <xsl:param name="body.margin.top" select="'1.5cm'" />
  <xsl:param name="header.table.height">1.1cm</xsl:param>
  <xsl:param name="xep.extensions" select="1"/>
  <xsl:param name="body.start.indent" select="'0pt'" />
  <xsl:param name="hyphenate">false</xsl:param>
  <xsl:param name="alignment">start</xsl:param>
</xsl:stylesheet>
