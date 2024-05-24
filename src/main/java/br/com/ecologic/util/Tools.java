package br.com.ecologic.util;

import java.util.Calendar;
import java.util.Date;

public class Tools {

    public static Date retornaDataPosteriorDiasCorridos(Date date, Integer qtde_dias) {

        Date dt_retorno = null;
        try {
            Calendar cal = Calendar.getInstance();
            Date data = new Date(date.getTime());
            cal.setTime(data);
            cal.add(Calendar.DATE, + qtde_dias);

            dt_retorno = new Date(cal.getTime().getTime());

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return dt_retorno;
    }

}
