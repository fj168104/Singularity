import Controller from './Controller';
import NotFoundView from '../views/notFound';

class NotFoundController extends Controller {

  initialize() {
    this.title('Not Found');
    this.setView(new NotFoundView());
    app.showView(this.view);
  }
}


export default NotFoundController;