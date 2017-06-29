
public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int arr[] = {0, 1, 2, 3, 4, 5};

		link(1, 2, arr);
		System.out.println("1 and 2 link");
		link(3, 4, arr);
		System.out.println("3 and 4 link");
		link(4, 5, arr);
		System.out.println("4 and 5 link");

		if(find(3,arr) == find(4,arr)){
			System.out.println("3 and 4 are same set");
		}else{
			System.out.println("3 and 4 are different set");
		}
		if(find(2,arr) == find(4,arr)){
			System.out.println("2 and 4 are same set");
		}else{
			System.out.println("2 and 4 are different set");
		}

		link(2,4,arr);
		System.out.println("2 and 4 link");

		if(find(3,arr) == find(4,arr)){
			System.out.println("3 and 4 are same set");
		}else{
			System.out.println("3 and 4 are different set");
		}

		if(find(1,arr) == find(5,arr)){
			System.out.println("1 and 5 are same set");
		}else{
			System.out.println("1 and 5 are different set");
		}

	}


	public static int find(int x, int arr[]){

		if(arr[x] == x){
			return x;
		}else{
			return arr[x] = find(arr[x],arr);
		}

	}

	public static void link(int x, int y, int arr[]){
		arr[find(y,arr)] =find(x,arr);
	}

}
