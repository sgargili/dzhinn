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

        Arrays.sort(Input);

        int k = 1;

        for (int i = 1; i < Input.length; i++) {
            if (!Input[i].equals(Input[i - 1])) {
                Input[k++] = Input[i];
            }
        }

        String[] Output = new String[k];

        System.arraycopy(Input, 0, Output, 0, k);

        return Output;
    }
}
