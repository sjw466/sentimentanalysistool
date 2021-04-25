import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {
        private Text output = new Text();

        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
                String line = value.toString();
                String[] words = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                //String[] words= line.split(",");
                if(words[0].equals("politics")){
                        output.set(words[0]+","+ words[1]);
                        context.write(new Text(""), output);
                }
        }
}
