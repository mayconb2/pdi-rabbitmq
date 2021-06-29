const Chat = () => {
  return (
    <>
      <form action="">
        <div>
          <div className="mb-6">
          <label className="form-label">Seu nome</label>
          <input type="text" className="form-control"/>
          </div>
          
          <br/>

          <div>
            <div className="mb-6">
            <label className="form-label">Mensagem</label>
            <input type="text" className="form-control"/>
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
