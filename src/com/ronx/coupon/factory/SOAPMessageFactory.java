package com.ronx.coupon.factory;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

public class SOAPMessageFactory {

    public void construct(){

        try {

            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage();



            // Add header entries here.

            SOAPHeader soapHeader = message.getSOAPHeader();



            // Application name header.

            QName qNameForCompanyURL = new QName("http://service.coupon.ronx.com/", "Company-URL", "coupon");
            SOAPHeaderElement headerForAppName;
            {
                headerForAppName = soapHeader.addHeaderElement(qNameForCompanyURL);
                headerForAppName.addTextNode("www.pokupon.by"); // TODO: for example
            }

//            message.


//            QName qNameForCurrency = new QName("http://service.coupon.ronx.com/", "Company-Name", "coupon");
//            {
//
//            }

//            SOAPHeaderElement headerForCurrency = soapHeader.addHeaderElement(qNameForCurrency);
//
//            headerForCurrency.addTextNode("INR");



            // The SOAP part of the message.

//            SOAPPart soapPart = message.getSOAPPart();
//
//            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
//
//            SOAPBody soapBody = soapEnvelope.getBody();
//
//
//
//            QName qNameForAccNo = new QName("http://myBank.com", "Account-No", "bank");
//
//            SOAPBodyElement elementForAccNo =
//
//                    soapBody.addBodyElement(qNameForAccNo);
//
//            elementForAccNo.addTextNode("123456789");
//
//
//
//            QName qNameForTotalAmount = new QName("http://myBank.com", "Total-Amount", "bank");
//
//            SOAPBodyElement elementForTotalAmount =
//
//                    soapBody.addBodyElement(qNameForTotalAmount);
//
//            elementForTotalAmount.addTextNode("75000.00");



            message.writeTo(System.out);

        }   catch(Exception exception){

            exception.printStackTrace();

        }

    }

}
