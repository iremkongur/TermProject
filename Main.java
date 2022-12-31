import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) throws IOException{
        	
                List<List<String>> list = readValues();
                System.out.println(list.get(0));
                
		List<Integer> valueList = new ArrayList<Integer>();
		List<Integer> weightList = new ArrayList<Integer>();
		
		
		for(int i=1;i<list.size();i++) {
			valueList.add(Integer.parseInt(list.get(i).get(4))); 
			weightList.add((int) (Integer.parseInt(list.get(i).get(5))*0.000016666666666666667));
		}
		
		int totalduration=30;
		System.out.println(recursive((128000*0.000016666666666666667),valueList,weightList,totalduration));
		
	
		double missingduration;
		double currenttotalinsec;
		double decreaseinalbumvalue;
		
		currenttotalinsec=((double)recursive(128000,valueList,weightList,totalduration))*60;
		
			if(currenttotalinsec < (totalduration*60)) {
				
				missingduration= (totalduration*60)-currenttotalinsec;
				decreaseinalbumvalue=missingduration*(0.02);
				
				System.out.println("Decrease in album value: " + decreaseinalbumvalue);
		
		}
		
		
		List<List<String>> list1 = readSequential();
		List<ArrayList<Double>> sequential_data = new ArrayList<ArrayList<Double>>();
		
		for (int i=1;i<list1.size();i++){
			ArrayList<Double> row = new ArrayList<>();
			for (int j=1;j<list1.get(0).size();j++){
				row.add(Double.parseDouble(list1.get(i).get(j)));
			}
			sequential_data.add(row);
		}
		System.out.println(sequential_data.get(0).get(1));
		
		

        }
        
        public static int recursive(double m, List<Integer> v, List<Integer> w, int t){
            int take = 0;
            int donottake = 0;
            if (m == 0){
                    return 0;
            }
            else{
                 if(w.get((int) m) <= t){
                      take = v.get((int) m) + recursive(m-1, v, w, t-w.get((int) m));
                 }
              donottake = recursive(m-1, v, w, t);
              return Math.max(take,donottake);
            }
        }

        
        
        
        public static List<List<String>> readValues() throws IOException { 
                try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store data
			String file = "term_project_value_data.csv";//file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			for(List<String> list : data)
			{
				for(String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
                        return data;
		}
		catch(Exception e)
		{
			System.out.print(e);
                        List< List<String> > data = new ArrayList<>();//list of lists to store data
                        return data;
		}
                
        }
	public static List<List<String>> readSequential() throws IOException { 
                try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store data
			String file = "term_project_sequential_data.csv";//file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			for(List<String> list : data)
			{
				for(String str : list)
					System.out.print(str + " ");
				System.out.println();
			}
			br.close();
                        return data;
		}
		catch(Exception e)
		{
			System.out.print(e);
                        List< List<String> > data = new ArrayList<>();//list of lists to store data
                        return data;
		}
                
        }
}
