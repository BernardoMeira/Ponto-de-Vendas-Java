
package trabalhoprj.Executar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import trabalhoprj.Classes.Venda;


public class ImprimirTabela implements	Printable{
        private Venda venda;
        private	JTable tabela;
        private PrinterJob printerJob;
        private Graphics graphics;
        private Graphics2D graphics2d;
        private int headerLines = 1;  
        private int fontSize = 9; 
        
        public ImprimirTabela(JTable tabela, Venda venda){
            this.tabela	= tabela;
            this.venda = venda;
            printerJob= printerJob.getPrinterJob();
            printerJob.setPrintable(this);
            printerJob.setJobName("Documento");
            if (printerJob.printDialog()){
	        try{
	            printerJob.print();
                } catch	(PrinterException ex){
	            JOptionPane.showMessageDialog(null,"Ocorreu um erro durante a impressão. \n"+ex.toString(),"Erro do Sistema",JOptionPane.ERROR_MESSAGE);
	        }
            }
        }
        
        public int print(Graphics g,PageFormat pageFormat,int pageIndex)throws	PrinterException{
            graphics2d = (Graphics2D)g;
            graphics2d.setColor(Color.black);
            Font myFont = new Font("Courier", Font.PLAIN, fontSize);
            graphics2d.setFont(myFont);
            int fontHeight = graphics2d.getFontMetrics().getHeight();
            int fontDescent = graphics2d.getFontMetrics().getDescent();
            int lineHeight = fontHeight + fontDescent;
            double pageHeight =	pageFormat.getImageableHeight()-fontHeight;
            double pageWidth = pageFormat.getImageableWidth();
            double tableWidth =	(double)tabela.getColumnModel().getTotalColumnWidth();
            double scale = 1;
            if (tableWidth >= pageWidth){
                scale = pageWidth / tableWidth;
	    }
            double headerHeightOnPage =	(tabela.getTableHeader().getHeight()*scale);
            double tableWidthOnPage = tableWidth*scale;
            double oneRowHeight = (tabela.getRowHeight()+ tabela.getRowMargin())*scale;
            int numRowsOnAPage = (int)((pageHeight-headerHeightOnPage)/oneRowHeight);
            double pageHeightForTable =	(oneRowHeight*numRowsOnAPage);
            int totalNumPages =	(int)Math.ceil( ( (double)tabela.getRowCount() ) / numRowsOnAPage);
            if	(pageIndex >= totalNumPages){
             	return NO_SUCH_PAGE;
             	}
            int currentY = 800 + lineHeight;
            int currentX = 10;
                graphics2d.drawString("DATA DA VENDA: " + venda.obterData() + "  -  " + "HORA DA VENDA: " + venda.obterHora() + "  -  " + "CODIGO: " + venda.obterCodigoVenda() + "  -  " + "CLIENTE: " + venda.obterCliente() + "  -  " + "FORMA PAGAMENTO: " + venda.obterFormaPagamento(), currentX, currentY);
            graphics2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
            graphics2d.translate(0f,headerHeightOnPage);
            graphics2d.translate(0f,-pageIndex*pageHeightForTable);
            if (pageIndex + 1 == totalNumPages){
             	int lastRowPrinted = numRowsOnAPage * pageIndex;
             	int numRowsLeft	= tabela.getRowCount() - lastRowPrinted;
             	graphics2d.setClip(0,(int)(pageHeightForTable * pageIndex),(int)Math.ceil(tableWidthOnPage),(int)Math.ceil(oneRowHeight * numRowsLeft));
            }else{    
             	graphics2d.setClip(0,(int)(pageHeightForTable*pageIndex),(int)Math.ceil(tableWidthOnPage),(int)Math.ceil(pageHeightForTable));        
            }
            graphics2d.scale(scale,scale);
            tabela.paint(graphics2d);
            graphics2d.scale(1 / scale,1 / scale);
            graphics2d.translate(0f,pageIndex * pageHeightForTable);
            graphics2d.translate(0f,-headerHeightOnPage);
            graphics2d.setClip(	0,0,(int)Math.ceil(tableWidthOnPage), (int)Math.ceil(headerHeightOnPage));
            graphics2d.scale(scale,scale);
            tabela.getTableHeader().paint(graphics2d);
            return Printable.PAGE_EXISTS;
        }
}
