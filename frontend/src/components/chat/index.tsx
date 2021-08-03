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
     
     {/* <div className="container"> */}
      <div className="p-3 bg-light border">
          <div className="row align-items-center">
            <div className="col-2 display-16"><p className="fw-bold">Usuário</p></div>
            <div className="col-10 display-8"><p className="fw-bold">Mensagem</p></div>
          </div>
          
            {
              chatMessage.map(m => (
                <>
                  <div className="row align-items-center">
                    <div className="col-2">
                        {m.user}
                    </div>
                    <div className="col-10">
                        {m.message}
                    </div>
                  </div>
                </>
            ))
            }
      </div>
     {/* </div> */}
      

     </>
  )
}

export default Chat;
