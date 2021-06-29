import axios from 'axios';
import { useState } from 'react';

axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

const Chat = () => {

  const BASE_URL = 'localhost';
  const PORT = '8091';

  const [user, setUser] = useState('');
  const [message, SetMessage] = useState('');

  const onPostMessage = (e: React.SyntheticEvent) => {

    e.preventDefault();

    axios.post(`http://${BASE_URL}:${PORT}/api/v1/messages`,{user, message})
    .then(data => {
      alert(data.data);
      console.log(data);
    }).catch(e => {
      console.error(e);
    }).finally(() => {
      clearMessageField();
    });
  }

  const clearMessageField = () => {
    SetMessage('');
  }


  return (
    <>
      <form onSubmit={onPostMessage}>
        <div>
          <div className="mb-6">
          <label className="form-label">Seu nome</label>
          <input type="text" className="form-control" value={user} onChange={(e) => setUser(e.target.value)}/>
          </div>
          
          <br/>

          <div>
            <div className="mb-6">
            <label className="form-label">Mensagem</label>
            <input type="text" className="form-control" value={message} onChange={(e) => SetMessage(e.target.value)}/>
            </div>
          </div>
        </div>
        <br/>
        <button type="submit" className="btn btn-primary">Enviar</button>
      </form>
    </>
  )
}

export default Chat;
