package com.example.zoomMTI

import org.jpos.iso.ISOPackager
import org.jpos.iso.ISOChannel
import org.jpos.iso.ISOMsg
import org.jpos.iso.packager.GenericPackager
import org.jpos.iso.packager.XMLPackager
import org.junit.Test
import java.io.File

class Iso8583Test {
    @Test
    fun testMtiMessage() {
        // Load the ISO8583 configuration from XML
        val packager: ISOPackager = GenericPackager("src/test/resources/packager.xml")

        // Create an ISOMsg instance
        val isoMsg = ISOMsg()
        isoMsg.packager = packager

        // Set the Message Type Indicator (MTI)
        isoMsg.setMTI("0800")  // Example MTI for a transaction request

        // Set the specific fields you want to test
        isoMsg.set(7, "1016114307")  // Transmission date and time
        isoMsg.set(11, "415722")      // System trace audit number
        isoMsg.set(32, "04012")       // Acquiring institution identifier code
        isoMsg.set(70, "101")         // Network management information code

        // Optionally print or assert the constructed message
        println("MTI: ${isoMsg.mti}")
        println("Transmission Date and Time: ${isoMsg.getString(7)}")
        println("System Trace Audit Number: ${isoMsg.getString(11)}")
        println("Acquiring Institution Identifier Code: ${isoMsg.getString(32)}")
        println("Network Management Information Code: ${isoMsg.getString(70)}")

        // Add assertions to validate the constructed message
        assert(isoMsg.mti == "0800")  // Check that the MTI is set correctly
        assert(isoMsg.getString(7) == "1016114307") // Validate Transmission Date and Time
        assert(isoMsg.getString(11) == "415722")     // Validate System Trace Audit Number
        assert(isoMsg.getString(32) == "04012")      // Validate Acquiring Institution Identifier Code
        assert(isoMsg.getString(70) == "101")

    }
}