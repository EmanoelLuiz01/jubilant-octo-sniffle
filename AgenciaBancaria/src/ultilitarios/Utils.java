package ultilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class Utils {
	
		
		static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
	    
		public static String doubleToString(Double double1) {
			return formatandoValores.format(double1);
		}

		
	}


