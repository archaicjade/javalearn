
public class RadixMain {

	public static byte[] int2Bytes(int id) {
		byte[] arr = new byte[4];
	for (int i = 0; i < arr.length; i++) {
		arr[i]= (byte)((id >> i * 8 ) & 0xff);
	}
		return arr;
	}
	
	public static int bytes2Int(byte[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
		 sum += (int)((arr[i] & 0xff) << i*8);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʮ����תΪ��������
//		System.out.println(Integer.toBinaryString(112));//������
//		System.out.println(Integer.toHexString(112));//ʮ������
//		System.out.println(Integer.toOctalString(112));//�˽���
//		
//		//��������ת����ʮ����
//		
//		System.out.println(Integer.parseInt("111001",2));
//		System.out.println(Integer.parseInt("27",8));
//		System.out.println(Integer.parseInt("A8",16));
		
		
		byte[] arr = int2Bytes(8143);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+";");
		}
		System.out.println();
		
		int s = bytes2Int(arr);
		System.out.println(s);
	}

}
