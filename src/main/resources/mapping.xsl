<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <OrderList>
            <xsl:for-each select="orders/order">
                <Order>
                    <FirstName>
                        <xsl:value-of select="firstName"/>
                    </FirstName>
                    <LastName>
                        <xsl:value-of select="lastName"/>
                    </LastName>
                    <Email>
                        <xsl:value-of select="email"/>
                    </Email>
                    <ProductName>
                        <xsl:value-of select="item"/>
                    </ProductName>
                    <OrderNumber>
                        <xsl:value-of select="orderId"/>
                    </OrderNumber>
                    <Price>
                        <xsl:value-of select="price"/>
                    </Price>
                </Order>
            </xsl:for-each>
        </OrderList>
    </xsl:template>

</xsl:stylesheet>