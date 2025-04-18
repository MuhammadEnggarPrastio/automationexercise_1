@Grab('com.itextpdf:itextpdf:5.5.13')
import groovy.xml.XmlSlurper
import com.itextpdf.text.*
import com.itextpdf.text.pdf.*

String suiteReportPath = 'Reports/MyTestSuite/20250417_152500/JUnit_Report.xml' // Ganti sesuai path real
String pdfOutputPath = 'Reports/MyTestSuite/SummaryReport.pdf'

// Parse XML report
def xml = new XmlSlurper().parse(new File(suiteReportPath))

// Setup PDF
Document document = new Document()
PdfWriter.getInstance(document, new FileOutputStream(pdfOutputPath))
document.open()

document.addTitle("Katalon Test Suite Report")
document.add(new Paragraph("LAPORAN TEST SUITE"))
document.add(new Paragraph("Tanggal: ${new Date()}\n\n"))

xml.testcase.each { tc ->
	String name = tc.@name
	String classname = tc.@classname
	String time = tc.@time
	def failure = tc.failure

	String status = (failure.size() > 0) ? "FAILED" : "PASSED"

	document.add(new Paragraph("Test Case: ${name}"))
	document.add(new Paragraph("Class     : ${classname}"))
	document.add(new Paragraph("Durasi    : ${time}s"))
	document.add(new Paragraph("Status    : ${status}"))

	if (status == "FAILED") {
		document.add(new Paragraph("Error     : ${failure.text()}\n"))
	}

	document.add(new Paragraph("----------------------------------------\n"))
}

document.close()
println "PDF berhasil dibuat di: ${pdfOutputPath}"
