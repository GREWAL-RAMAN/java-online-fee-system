package grewal.servlet;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import grewal.bean.fee_payment;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Servlet implementation class SavePdf
 */
public class SavePdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("deprecation")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");

        // Create a new document
        Document document = new Document();
        try {
            // Create a temporary file path
            String filePath = "D:\\Pdf Saved\\Fee_payment pdf\\file.pdf";

            // create a FileOutputStream object to write to the file
            FileOutputStream fos = new FileOutputStream(filePath);
            PdfWriter.getInstance(document, fos);

            // Open the document
            document.open();
            document.add(new Paragraph("1"));

            // Retrieve data from the request
            String[] payments = request.getParameterValues("Payment");

            // Generate the HTML table
            StringBuilder tableHtml = new StringBuilder("<div style='text-align: center;'>"
                    + "  <h2>Reciept Details </h2> "
                    + "<table  border='2'>");
            tableHtml.append("<tr style='background-color: #333; color: #fff;'><th>Id</th><th>Student ID</th><th>Student Course Id</th><th>Amount</th><th>Payment Method</th><th>Date Time</th><th>Additional Info</th></tr>");

            // Add rows to the table
            if (payments != null && payments.length > 0) {
                for (String payment : payments) {
                    String[] paymentData = payment.split("/");
                    tableHtml.append("<tr style='background-color: #555; color: #ddd;'>");
                    for (String data : paymentData) {
                        tableHtml.append("<td>").append(data).append("</td>");
                    }
                    tableHtml.append("</tr>");
                }
            } else {
                // Add a message if there is no data to display
                tableHtml.append("<tr><td colspan='7'>No data to display</td></tr>");
            }
            tableHtml.append("</table>");

            // Add the HTML table to the document
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(tableHtml.toString()));

            // Close the document
            document.close();

            // Send the file to the client
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                response.getOutputStream().write(buffer, 0, length);
            }
            response.getOutputStream().flush();

            // Set the Content-Disposition header to open the PDF in a new tab
            response.setHeader("Content-Disposition", "inline; filename=" + file.getName());

        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            // Close the document
            document.close();
            response.sendRedirect("Fee_payments?function=view");
        }
    }




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
