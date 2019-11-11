package com.uam.poo;

import javax.swing.text.MaskFormatter;

/**
 * User: theo
 * Date: 11/11/2019
 * Time: 19:07
 */
public class MaskFactory {
    public static MaskFormatter mascara(String Mascara){

        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter('0'); //Caracter para preencimento
        }
        catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }
}
