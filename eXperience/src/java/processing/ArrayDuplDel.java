/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import java.util.Arrays;

/**
 *
 * @author PAV
 */
public class ArrayDuplDel {

//    private String[] Input;
//    private String[] Output;
    public String[] ArrayDuplDel(String[] Input) {
        try {
            Arrays.sort(Input);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        int k = 1;
        for (int i = 1; i < Input.length; i++) {
            try {
                if (!Input[i].equals(Input[i - 1])) {
                    Input[k++] = Input[i];
                }
            } catch (NullPointerException e) {
                System.out.println(e);
            }

        }
        String[] Output = new String[k];
        System.arraycopy(Input, 0, Output, 0, k);
        return Output;
    }
}
