package ccc.interaction.global;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkSurface {

	public static boolean isConnected() {
		Enumeration<NetworkInterface> eni;
		try {
			eni = NetworkInterface.getNetworkInterfaces();
			while(eni.hasMoreElements()) {
				Enumeration<InetAddress> eia = eni.nextElement().getInetAddresses(); {
					while(eia.hasMoreElements()) {
						InetAddress ia = eia.nextElement();
						if(!ia.isAnyLocalAddress() && !ia.isLoopbackAddress()&&!ia.isSiteLocalAddress()) {
							if(!ia.getHostAddress().equals(ia.getHostAddress()))
								return true;
						}
					}
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
