package com.ronx.coupon.server;


import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class CouponSOAPHandler implements SOAPHandler<SOAPMessageContext> {


    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders()......");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("Server : handleMessage()......");

        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        //for response message only, true for outbound messages, false for inbound
        if(!isRequest){

            try{
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnv.getHeader();

                //if no header, add one
                if (soapHeader == null){
                    soapHeader = soapEnv.addHeader();
                    //throw exception
                    generateSOAPErrMessage(soapMsg, "No SOAP header.");
                }

                //Get client mac address from SOAP header
                Iterator it = soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);

                //if no header block for next actor found? throw exception
                if (it == null || !it.hasNext()){
                    generateSOAPErrMessage(soapMsg, "No header block for next actor.");
                }

                //if no mac address found? throw exception
                Node macNode = (Node) it.next();
                String macValue = (macNode == null) ? null : macNode.getValue();

                if (macValue == null){
                    generateSOAPErrMessage(soapMsg, "No mac address in header block.");
                }

                //if mac address is not match, throw exception
                if(!macValue.equals("90-4C-E5-44-B9-8F")){
                    generateSOAPErrMessage(soapMsg, "Invalid mac address, access is denied.");
                }

                //tracking
                soapMsg.writeTo(System.out);

            }catch(SOAPException|IOException e){
                System.err.println(e);
            }

        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("Server : handleFault()......");

        return true;

    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Server : close()......");

    }


    private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
        try {
            SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
            SOAPFault soapFault = soapBody.addFault();
            soapFault.setFaultString(reason);
            throw new SOAPFaultException(soapFault);
        }
        catch(SOAPException e) { }
    }

}
