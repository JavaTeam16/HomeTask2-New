public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class DataStream {
        private byte[] data;

        public DataStream(byte[] data) {
            this.data = data;
        }

        public byte[] getData() {
            return data;
        }

        public void sendData(DataReceiver receiver) {
            receiver.receiveData(data);
        }
    }

    class DataReceiver {
        public void receiveData(byte[] data) {
            // Process received data
        }
    }

    class DataStreamManager {
        public void simulateDataExchange(DataStream sender, DataReceiver receiver) {
            sender.sendData(receiver);
        }
    }
}