package cs228hw4.graph;

public class Vertex<E> {
		public E a;
		public int aCost;
		public E b;
		public int bCost;
		public E c;
		public int cCost;
		public String name;

		public Vertex() {
			a = null;
			aCost = 0;
			b = null;
			bCost = 0;
			c = null;
			cCost = 0;
		}

		public Vertex(E a1, E b1, E c1, int aCost1, int bCost1, int cCost1) {
			a = a1;
			b = b1;
			c = c1;
			aCost = aCost1;
			bCost = bCost1;
			cCost = cCost1;
		}

		public void setName(String name)
		{
			this.name = name;
			
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setA(E a1) {
			a = a1;
		}

		public void setB(E b1) {
			b = b1;
		}

		public void setC(E c1) {
			c = c1;
		}

		public void setaCost(int aCost1) {
			aCost = aCost1;
		}

		public void setbCost(int bCost1) {
			bCost = bCost1;
		}

		public void setcCost(int cCost1) {
			cCost = cCost1;
		}
	
}
