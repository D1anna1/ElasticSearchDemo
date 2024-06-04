import com.project.errorlog.WriteErrorLog;
import com.project.errorlog.impl.WriteErrorLogImpl;

public class Test {
    public static void main(String[] args) {
        WriteErrorLogImpl writeErrorLog = new WriteErrorLogImpl();
        String outputPath = "output.txt";
        writeErrorLog.writeErrorLog(outputPath);
    }
}
