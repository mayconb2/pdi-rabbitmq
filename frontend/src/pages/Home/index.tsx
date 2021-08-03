import HeaderChat from "components/headerChat";

const Home = () => {
    return (
        <>
        <div className="container">
          
          <div className="jumbotron">
            <h1 className="display-8">PDI-MAYCON</h1>
            <p className="lead">Plano de Desenvolvimento Individal</p>
            <hr />
            <p>Aplicação usando Java, Spring, RabbitMQ e React.</p>
          </div>

          <HeaderChat/>
        </div>
        </>
    )
}

export default Home;