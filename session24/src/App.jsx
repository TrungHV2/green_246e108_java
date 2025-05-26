import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';

function App() {
  const [isNew, setIsNew] = useState(true);
  const [category, setCategory] = useState({});
  const categories = useSelector(state => state.categories);
  const dispacth = useDispatch();

  useEffect(() => {
    dispacth({type: 'CATEGORY_FECTH'});
  }, [])

  const handleChange = (event) => {
    setCategory(prevState => ({...prevState, [event.target.name]: event.target.value}));
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    let _action = isNew ? 'CATEGORY_ADD' : 'CATEGORY_EDIT';
    dispacth({type: _action, payload: category});
    console.log(category);
  }

  const handleEdit = (cate) => {
    setIsNew(false);
    setCategory(cate);
    console.log(isNew);
  }

  const handleNew = () => {
    setIsNew(true);
    setCategory(prev => ({id: '', name: ''}))
  }


  return (
    <div className="App container">
      <h1>List category</h1>
      <form onSubmit={handleSubmit}>
        <input type="text" name='id' placeholder='Id' value={category.id} onChange={handleChange} />
        <input type="text" name='name' placeholder='Name' value={category.name} onChange={handleChange} />
        {!isNew ? (<button className='btn btn-success' onClick={handleNew}>Create new</button>) : ''}
        <button className='btn btn-success'>Save</button>
      </form>
      <table className='table'>
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {categories.map(c => (
            <tr key={c.id}>
              <td>{c.id}</td>
              <td>{c.name}</td>
              <td><button className='btn btn-warning' onClick={() => {handleEdit(c)}}>Edit</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
