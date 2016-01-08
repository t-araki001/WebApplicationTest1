package jp.araki;

public class Escape {
	//クロスサイト他対策
	 public String escapeXSS(String xss) {
		   if (xss == null){
			   return "";
			   }
		   xss = xss.replaceAll("&", "&amp;");
		   xss = xss.replaceAll("<", "&lt;");
		   xss = xss.replaceAll(">", "&gt;");
		   xss = xss.replaceAll("\"", "&quot;");
		   xss = xss.replaceAll("'", "&#39;");

		   return xss;
		 }
}
