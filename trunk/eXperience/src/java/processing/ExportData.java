/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processing;

/**
 *
 * @author Admin4DB2
 */
public class ExportData {
     
     String DataType;
     String Language;
     String Status;
     String SubmitString;
     String ReqMethod;

     public String getDataType() {
          return DataType;
     }

     public void setDataType(String DataType) {
          this.DataType = DataType;
     }

     public String getLanguage() {
          return Language;
     }

     public void setLanguage(String Language) {
          this.Language = Language;
     }

     public String getReqMethod() {
          return ReqMethod;
     }

     public void setReqMethod(String ReqMethod) {
          this.ReqMethod = ReqMethod;
     }

     public String getStatus() {
          return Status;
     }

     public void setStatus(String Status) {
          this.Status = Status;
     }

     public String getSubmitString() {
          return SubmitString;
     }

     public void setSubmitString(String SubmitString) {
          this.SubmitString = SubmitString;
     }


}
