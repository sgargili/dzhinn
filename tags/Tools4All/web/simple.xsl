<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="4.0" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/">
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="itemCard">
        <!--<h2>Item card product=
            <xsl:value-of select="@products_id"/>
        </h2>-->

        <xsl:apply-templates select="marketing" mode="itemCard"/>
        <xsl:apply-templates select="link" mode="itemCard"/>
        <table class="spec_table">
            <tbody>
                <xsl:apply-templates select="group" mode="itemCard"/>
            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="group" mode="itemCard">

        <tr>
            <th colspan="2" class="spec_groupname">
                <xsl:value-of select="@name"/>
            </th>
        </tr>
        <xsl:for-each select="row">
            <tr>
                <td>
                    <xsl:value-of select="name"/>

                </td>
                <td>
                    <xsl:value-of select="value" disable-output-escaping="yes"/>
                </td>
            </tr>
        </xsl:for-each>
    </xsl:template>
    <xsl:template match="items">
        <table border="1" cellpadding="1" cellspacing="0" width="100%">

            <thead>
                <tr>
                    <th>id</th>
                    <th>code</th>
                    <th>manufacter</th>
                    <th>card</th>
                    <th>compare</th>

                    <th>ka</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates select="item" mode="items"/>
            </tbody>
        </table>
    </xsl:template>

    <xsl:template match="item" mode="items">
        <tr>
            <td>
                <xsl:value-of select="@products_id"/>
            </td>
            <td>
                <xsl:value-of select="@products_code"/>
            </td>
            <td>

                <xsl:value-of select="@manufacturers_name"/>
            </td>
            <td>
                <a>
                    <xsl:attribute name="href">
                        <xsl:value-of select="card_url"/>
                    </xsl:attribute>card
                </a>
            </td>
            <td>
                <a>

                    <xsl:attribute name="href">
                        <xsl:value-of select="compare_url"/>
                    </xsl:attribute>comp
                </a>
            </td>
            <td>
                <a>
                    <xsl:attribute name="href">
                        <xsl:value-of select="ka_url"/>
                    </xsl:attribute>keyattr
                </a>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="marketing" mode="itemCard">
        <div id="marketing">
            <xsl:value-of select="text()" disable-output-escaping="yes"/>
        </div>
    </xsl:template>
    <xsl:template match="link" mode="itemCard">
        <div id="link">
            <a href="{@url}">
                <xsl:value-of select="@name"/>
            </a>
        </div>

    </xsl:template>


    <xsl:template match="itemImages">
        <table border="1" cellpadding="1" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>id</th>
                    <th>w</th>

                    <th>h</th>
                    <th>src</th>
                    <th>view</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates select="itemImage" mode="itemImages"/>

            </tbody>
        </table>
    </xsl:template>
    <xsl:template match="itemImage" mode="itemImages">
        <tr>
            <td>
                <xsl:value-of select="@products_id"/>
            </td>
            <td>

                <xsl:value-of select="@width"/>
            </td>
            <td>
                <xsl:value-of select="@height"/>
            </td>
            <td>
                <xsl:value-of select="@src"/>
            </td>
            <td>

                <a href="{@src}" target="_new">view</a>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="itemCompare">
        <h2>Item compare card product=
            <xsl:value-of select="@products_id"/> lang=
            <xsl:value-of select="@lang"/>
        </h2>

        <xsl:for-each select="template">
            <table border="1" cellpadding="1" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th colspan="2">template
                            <xsl:value-of select="@id"/>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <xsl:apply-templates select="group" mode="itemCompare"/>

                </tbody>
            </table>
        </xsl:for-each>
    </xsl:template>
    <xsl:template match="group" mode="itemCompare">
        <tr>
            <th colspan="2">
                <xsl:value-of select="@name"/>
            </th>

        </tr>
        <xsl:apply-templates select="attribute" mode="itemCompare"/>
    </xsl:template>
    <xsl:template match="attribute" mode="itemCompare">
        <tr>
            <td>
                <xsl:value-of select="@name"/>
            </td>
            <td>

                <xsl:for-each select="value">
                    <xsl:value-of select="@displayValue"/>
                    <br/>
                </xsl:for-each>
            </td>
        </tr>
        <xsl:apply-templates select="attribute" mode="itemCompare"/>
    </xsl:template>
</xsl:stylesheet>
