/*2012년 12월 31일 새벽 4시부터 지상파 아날로그 TV방송이 종료되었다. TV를 자주보는 할머니를 위해서, 상근이네 집도 디지털 수신기를 구입했다.
원래 상근이네 집에는 KBS1과 KBS2만 나왔다. 할머니는 두 방송만 시청한다. 이제 디지털 수신기와 함께 엄청난 양의 채널을 볼 수 있게 되었다.  
하지만, 할머니는 오직 KBS1과 KBS2만 보려고 한다. 따라서, 상근이는 채널 리스트를 조절해 KBS1을 첫 번째로, KBS2를 두 번째로 만들려고 한다.
티비를 켜면 디지털 수신기는 시청 가능한 채널 리스트를 보여준다. 모든 채널의 이름은 서로 다르고, 항상 KBS1과 KBS2를 포함하고 있다. 
상근이는 이 리모콘을 이용해서 리스트의 순서를 바꾸는 법을 알아냈다. 리스트의 왼편에는 작은 화살표가 있고, 이 화살표는 현재 선택한 채널을 나타낸다. 
가장 처음에 화살표는 제일 첫 번째 채널을 가리키고 있다.
다음과 같은 네 가지 버튼을 이용해서 리스트의 순서를 바꿀 수 있다. 각각은 1번부터 4번까지 번호가 적혀져있는 버튼이다.

1번 버튼 : 화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
2번 버튼 :화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
3번 버튼 :현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
4번 버튼 :현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)
<주의!!> 화살표가 채널 리스트의 범위를 넘어간다면, 그 명령은 무시한다.

현재 채널 리스트의 순서가 주어졌을 때, KBS1를 첫 번째로, KBS2를 두 번째로 순서를 바꾸는 방법을 구하는 프로그램을 작성하시오. 
방법의 길이는 500보다 작아야 한다. 두 채널을 제외한 나머지 채널의 순서는 상관없다.
<입력>					<출력>
ABC1					11144411144
ABC02
KBS2
KBS1

정답은 여러가지 입니다. 1~4번 버튼을 잘 이용해서 푸세요
*/
public class DigitalTv {
	public static String solution(String[] channel) {
		StringBuffer sb = new StringBuffer();
		int kbs1idx=1000;
		int kbs2idx=1000;
		
		for(int i=0; i<channel.length; i++) {
			if(channel[i].equalsIgnoreCase("KBS1")) {
				kbs1idx=i;
				if(kbs1idx ==1000) return null;
				if(kbs1idx == 0) break;
				
				int tempIdx = kbs1idx;
				while(tempIdx != 0) {
					sb.append(1);
					tempIdx--;
				}
				while(kbs1idx != 0) {
					sb.append(4);
					String tempString ="";
					tempString=channel[kbs1idx];
					channel[kbs1idx] = channel[kbs1idx-1];
					channel[kbs1idx-1] = tempString;
					kbs1idx--;
				}
			}
		}
		
		for(int i=1; i<channel.length; i++) {
			if(channel[i].equalsIgnoreCase("KBS2")) {
				kbs2idx=i;
				if(kbs2idx ==1000) return null;
				if(kbs2idx == 0) break;
				
				int tempIdx = kbs2idx;
				while(tempIdx != 0) {
					sb.append(1);
					tempIdx--;
				}
				while(kbs2idx != 1) {
					sb.append(4);
					String tempString ="";
					tempString=channel[kbs2idx];
					channel[kbs2idx] = channel[kbs2idx-1];
					channel[kbs2idx-1] = tempString;
					kbs2idx--;
				}
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"ABC1", "ABC02", "KBS2", "MBC", "KBS1"}));
	}

}
