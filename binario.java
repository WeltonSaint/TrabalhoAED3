import java.util.*;
import java.io.*;

class Bloco
{
	private List<String> elementos = new ArrayList<>();
	
	Bloco()
	{
	}
	
	public void add(String linha)
	{
		elementos.add(linha);
	}
	public void del(int n)
	{
		elementos.remove(n);
	}
	public String get(int n)
	{
		return elementos.get(n);
	}
	public int size()
	{
		return elementos.size();
	}
	
	public String toString()
	{
		String ret = "";
		for(int i=0; i<elementos.size(); i++)
		{
			ret += elementos.get(i) + "\n";
		}
		return ret;
	}
}

public class binario
{
	public static void main(String[]args)
	{
		try
		{
			int qtdBlocos  = 0;
			Bloco[] blocos = null;
			RandomAccessFile arquivo = new RandomAccessFile(new File("in.txt"), "r");
		
			qtdBlocos = Integer.parseInt(arquivo.readLine());
			blocos    = new Bloco[qtdBlocos];	
			for(int i=0; i<qtdBlocos; i++) blocos[i] = new Bloco();
			
			//ignora uma linha
			arquivo.readLine();
			
			//Obtencao de todos os blocos
			String linha = "";
			for(int i=0,pos=0; i<qtdBlocos; i++)
			{
				linha = arquivo.readLine();
				while( linha != null && !linha.equals("") )
				{
					blocos[pos].add(linha);
					linha = arquivo.readLine();
				}
				pos++;
			}

			//Combinacao dos elementos e obtencao do dado
			for(int i=0; i<qtdBlocos; i++)
			{
				List<String> comb = new ArrayList<>();
				comb.clear();
				for(int j=0; j<blocos[i].size()/2; j++)
				{
					for(int k=blocos[i].size()/2; k<blocos[i].size(); k++)
					{
						comb.add(blocos[i].get(j) + blocos[i].get(k));
					}
				}
			
				int ind = 0;
				int rep = 0;
				for(int j=0; j<comb.size(); j++)
				{
					for(int k=0; k<comb.size(); k++)
					{
						if(j != k && comb.get(j).equals(comb.get(k)) )
						{
							rep = rep+1;
						}
					}
				
					if(rep == (blocos[i].size()/2)-1 )
					{
						ind = j;
						j = comb.size();
					}
					else
					{
						rep = 0;
					}
				}		
				System.out.println("Achei: "+comb.get(ind));
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}		
	}
} 
