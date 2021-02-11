function AdminUserServiceClient() {

    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/chen.tianyi/users';
    var self = this;
    var users = [];

    function createUser(user) {
     return fetch(self.url, {
       method: 'POST',
       body: JSON.stringify(user),
       headers: {
         'content-type': 'application/json'
       }
     }).then(function (response) {
       return response.json()
     })
    }


    function findAllUsers() {
        return fetch(self.url)
            .then((response) => {
               return response.json()
           })
    }


    function findUserById(id) {
        return fetch(`${self.url}/${id}`)
            .then((response) => {
                return response.json()
            })
    }

    function updateUser(id, user) {
        return fetch(`${self.url}/${id}`, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        }).then(response => response.json())
    }


    function deleteUser(id) {
        return fetch(`${self.url}/${id}`, {
            method: "DELETE"
        })
    }


}