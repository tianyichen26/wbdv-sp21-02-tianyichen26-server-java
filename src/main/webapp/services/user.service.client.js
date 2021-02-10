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
        users.push(user);
        return users;
    }


    function findAllUsers() {
        return $.getJSON("../admin/users.json",function (data) {
                users = data;
                return users;
        })
    }


    function findUserById(userId) {
        for (var i = 0; i < users.length; i++) {
            if(users[i].id==userId){
                return users[i];
            }
        }
    }

    function updateUser(userId, user) {
        for (var i = 0; i < users.length; i++) {
            if(users[i].id==userId){
                users[i] = user;
                return users;
            }
        }
    }


    function deleteUser(userId) {
        for (var i = 0; i < users.length; i++) {
            if(users[i].id==userId){
                users.splice(i,1);
                break;
            }
        }
        return users;
    }


}