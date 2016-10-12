/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.dmartínezc.a10;

import DataStructure.Stack.*;
import java.util.Scanner;

/**
 *
 * @author danx_
 */
public class EDDMartínezCA10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // balanceo
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese una ecuacion: ");
        String ec = scan.nextLine();//Se ingresa la ecuacion
        Stack stack = new Stack();
        boolean flag = true;

        //Se recorre la ecuacion en busca de '(','[' o '{'
        for (int i = 0; i < ec.length() && flag; i++) {
            //Por cada '(','[' o '{', se hace un push del simbolo al stack
            switch (ec.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                
                //Si el simbolo es de cerrar se hace verifica si el simbolo es del mismo tipo que el ultimo abierto, o si el stack es null
                case ')':
                    if (stack.getSize() == 0) {
                        flag = false;
                    } else if (stack.getTop().getData().equals('(')) {
                        stack.pop();
                    } else {
                        flag = false;
                    } 
                    break;
                case ']':
                    if (stack.getSize() == 0) {
                        flag = false;
                    } else if (stack.getTop().getData().equals('[')) {
                        stack.pop();
                    } else {
                        flag = false;
                    } 
                    break;
                case '}':
                    if (stack.getSize() == 0) {
                        flag = false;
                    } else if (stack.getTop().getData().equals('{')) {
                        stack.pop();
                    } else {
                        flag = false;
                    } 
                    break;
            }
        }

        
        if (flag && stack.isEmpty()) {
            System.out.println("Ecuacion balanceada");
        } else {
            System.out.println("Ecuacion no balanceada");
        }
    }

}
