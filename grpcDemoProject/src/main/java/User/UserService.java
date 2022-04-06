package User;

import com.yrrhelp.grpc.User;
import com.yrrhelp.grpc.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside Login");
        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        if(username.equals(password))
        {
            response.setResponseCode(0).setResponseMessage("SUCCESS");
        }
        else
        {
            response.setResponseCode(100).setResponseMessage("INVALID PASSWORD OR USERNAME");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }
}
