import Chat from "components/chat";

const Home = () => {
    return (
        <>
        <div className="container">
          
          <div className="jumbotron">
            <h1 className="display-4">PDI-MAYCON</h1>
            <p className="lead">Plano de Desenvolvimento Individal</p>
            <hr />
            <p>Aplicação usando Java, Spring, RabbitMQ e React.</p>
          </div>

          <Chat/>
        </div>
        </>
    )
}

export default Home;