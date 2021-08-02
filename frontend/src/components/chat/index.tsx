import axios from 'axios';
import { useState, useEffect  } from 'react';
import { Message } from 'types/message';

axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

const Chat = () => {

  const BASE_URL = 'localhost';
  const PORT = '9090';


  const [chatMessage, setChatMessage] = useState<Message[]>([]);
  // const [id, setId] = useState<Number>(0);


  useEffect(() => {
    
    // setInterval(() => {
      console.log('fetching...')
      axios.get(`http://${BASE_URL}:${PORT}/api/v1/messages/getAllMessages`).then(data => {
        // console.log(data.data)
        setChatMessage(data.data);
      })
    // }, 1000)
  },[]);

  return (
    <>
     
      <div>
            <table>
              <tr>
                <th>Usuário</th>
                <th>Msg</th>
              </tr>
              <tbody>
                {
                  chatMessage.map(m => (
                    <tr>
                        <td>{m.user}</td>
                        <td>{m.message}</td>
                    </tr>
                ))
                }
              </tbody>
            </table>
          </div>

     </>
  )
}

export default Chat;
