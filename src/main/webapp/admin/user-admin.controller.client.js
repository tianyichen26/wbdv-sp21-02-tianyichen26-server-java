(function () {

  var $usernameFld, $passwordFld;
  var $firstNameFld, $lastNameFld, $roleFld;
  var $removeBtn, $editBtn, $createBtn, $updateBtn;
  var $userRowTemplate, $tbody;
  var users = [];
  var userService = new AdminUserServiceClient();

  $(main);
  function main() {
    $usernameFld = $("#usernameFld");
    $passwordFld = $("#passwordFld");
    $firstNameFld = $("#firstNameFld");
    $lastNameFld = $("#lastNameFld");
    $roleFld = $("#roleFld");
    $createBtn = $(".wbdv-create");
    $updateBtn = $(".wbdv-update");
    $tbody = $(".wbdv-tbody");
    $userRowTemplate = $(".wbdv-template.wbdv-user");
    $createBtn.click(createUser);
    $updateBtn.click(updateUser);
  }

  function createUser() {
    const username = $usernameFld.val();
    const password = $passwordFld.val();
    const firstName = $firstNameFld.val();
    const lastName = $lastNameFld.val();
    const role = $roleFld.val();

    var user = new User(username, password, firstName, lastName, role);
    userService.createUser(user).then((actualUser) => {
      findAllUsers()
    });
  }

  function updateUser() {
    selectedUser.username = $usernameFld.val();
    selectedUser.password = $passwordFld.val();
    selectedUser.firstName = $firstNameFld.val();
    selectedUser.lastName = $lastNameFld.val();
    selectedUser.role = $roleFld.val();


    userService.updateUser(selectedUser._id, selectedUser).then(updatedUser => {
      findAllUsers();
      currentUserIndex = -1;
    })
  }


  function findAllUsers() {
    userService.findAllUsers().then(all => {
      users = all;
      renderUsers()
    })
  }findAllUsers()


  function deleteUser(index) {
    const userId = users[index]._id;
    userService.deleteUser(userId).then(response => {
      users.splice(index, 1);
      renderUsers(users)
    })
  }

  var currentUserIndex = -1;
  var selectedUser = null;

  function selectUser(index){
    const userId = users[index]._id;
    currentUserIndex = index;
    selectedUser = users[index];
    userService.findUserById(userId).then((user) => {
      $usernameFld.val(user.username);
      $passwordFld.val(user.password);
      $firstNameFld.val(user.firstName);
      $lastNameFld.val(user.lastName);
      $roleFld.val(user.role);
    })
  }


  function renderUser(user, index) {
    var dataclone = $userRowTemplate.clone();

    dataclone.removeClass("wbdv-hidden");
    dataclone.removeClass("wbdv-template");
    dataclone.find(".web-username").html(user.username);
    dataclone.find(".web-firstname").html(user.firstName);
    dataclone.find(".web-lastname").html(user.lastName);
    dataclone.find(".web-role").html(user.role);
    dataclone.attr("id", user.id);
    $removeBtn = dataclone.find("#wbdv-remove")
    $removeBtn.click(() => deleteUser(index));
    $editBtn = dataclone.find("#wbdv-edit");
    $editBtn.click(() => selectUser(index));
    $tbody.append(dataclone);
  }


  function renderUsers() {
      $tbody.empty();
      for(var u in users) {
        var user = users[u];
        renderUser(user, u);
      }
  }



})();