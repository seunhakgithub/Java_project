/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm27subjtextfield;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class SM27SubJTextField extends JTextField{
    private boolean number=false;
    private boolean floating=false;
    private int digit=-1;
    public SM27SubJTextField() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                subKeyTyped(e);
                //super.keyTyped(e); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }
    private void subKeyTyped(KeyEvent evt){
        if(isNumber()){
            if(getDigit()>=0)
                MyInput.inputInteger(evt, this, getDigit());
            else
                MyInput.inputInteger(evt);
        }else if(isFloating()){
            if(getDigit()>=0)
                MyInput.inputFloating(evt, this, getDigit());
            else
                MyInput.inputFloating(evt, this);
        }else{
            String st=this.getText();
            if(getDigit()>=0)
                if(st.length()>=getDigit())
                    evt.consume();
        }
    }
    public SM27SubJTextField(String text) {
        this();
        this.setText(text);
    }

    public int getIntegerNumber(){
        return Integer.valueOf(this.getText());
    }
    public long getLongNumber(){
        return Long.valueOf(this.getText());
    }
    public float getFloatNumber(){
        return Float.valueOf(this.getText());
    }
    public double getDoubleNumber(){
        return Double.valueOf(this.getText());
    }
    /**
     * @return the number
     */
    public boolean isNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(boolean number) {
        this.number = number;
        if(number)
            setFloating(false);
    }

    /**
     * @return the floating
     */
    public boolean isFloating() {
        return floating;
    }

    /**
     * @param floating the floating to set
     */
    public void setFloating(boolean floating) {
        this.floating = floating;
        if(floating)
            setNumber(false);
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return digit;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        this.digit = digit;
    }
}
