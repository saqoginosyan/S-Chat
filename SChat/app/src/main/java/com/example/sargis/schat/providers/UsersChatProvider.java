package com.example.sargis.schat.providers;

import com.example.sargis.schat.models.MessageModel;
import com.example.sargis.schat.models.UsersModel;

import java.util.ArrayList;
import java.util.List;

public class UsersChatProvider {
    private static List<UsersModel> usersList = new ArrayList<>();

    public static List<UsersModel> getUsersList(){

        if (!usersList.isEmpty()) {
            usersList.clear();
        }

        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/22221627_1605082922881314_630331231347394490_n.jpg?_nc_cat=0&oh=6d328993e641707ba86d4ba38646fc01&oe=5BD5144C", "Smbat Sargsyan", "Txeq nenc chaneq nexananq iraric...","+37495800177","smbatsargsyan1992@gmail.com","08/08/1992",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t31.0-8/23593494_1814687975270535_2779060799463349705_o.jpg?_nc_cat=0&oh=4ff803b702036f10f81f886a4bd5c7e7&oe=5BD78356", "Saqo Ginosyan", "Uzum em qnem","+37455777855","saqoginosyan@gmail.com","05/02/1994",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/14641904_1228487950534760_7861809859203943937_n.jpg?_nc_cat=0&oh=6d99d4002167727da6bd2df84951f05e&oe=5BE7409E", "Taron Martirosyan", "Chgitem notebook vercnem te avto...","+37494810110","taronmartirosyan92@gmail.com","03/03/1992",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/14502917_556258197900564_30987170087046250_n.jpg?_nc_cat=0&oh=44590cc5946234ac1d51590d1f77fe8e&oe=5BD95BE5", "Hayk Petrosyan", "Ekeq blot xaxanq","+37455050029","hayk5555@list.ru","29/05/1991",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t31.0-1/c282.0.960.960/p960x960/10506738_10150004552801856_220367501106153455_o.jpg?_nc_cat=0&oh=f9ed6f4c4ee5fab23b904865e6472356&oe=5B9FD312", "Vardan Vanyan", "Aaaaaaa Smbo jan lav eli","+37498119192","vanyan1992@inbox.ru","08/05/1992",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/32702597_974278669387269_6466733890227666944_n.jpg?_nc_cat=0&oh=cdc6259eaba90f3d298f374cc9454f5b&oe=5BE8B4FF", "Ero Ero", "6-in em qnel","+37494153761","ero-87@mail.ru","02/10/1987",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/34777604_613101162402833_3931473901523042304_n.jpg?_nc_cat=0&oh=8fdd11e3555c653ad2aa074dc00497e9&oe=5BA302A4", "Aren Gevorgyan", "Secondi code@ firsti mej em grelu ?","+37494033456","arengevorgyan0907@mail.ru","09/07/1996",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/31950017_842296865978091_1679414749122527232_n.jpg?_nc_cat=0&oh=76554a6485728b80f968ff5e83650a0f&oe=5BCE5DDE", "Levon Shovgaryan", "usumnasirum em Garbage collectori himunqner@...","+37493197925","lshovgaryan@gmail.com","08/04/2000",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/22540071_529358554071980_5244304309795988525_n.jpg?_nc_cat=0&oh=95817815a49d04273077e928475d1ae9&oe=5BE613B1", "Gagik Abovyan", "9-in ? 9-in ?","+37455118896","gagik-abovyan@inbox.ru","30/12/1999",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/21314738_806990199461963_7939366341695141074_n.jpg?_nc_cat=0&oh=de4e8c0cf79c32faad8ae1a11fc063d7&oe=5BD6FBC5", "Azat Ayvazyan", "Baryor dzez","+37495666700","Ayvazyan.95@mail.ru","--/--/--",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/30724772_1476408359154479_5999781021422190592_n.jpg?_nc_cat=0&oh=bdc9635ab71940d58c9412e72f04bb4a&oe=5BE0E926", "A-Yan Vahe", "erexek qamry-i ejan svecha vortexic charem","+374557771102","---","24/02/1997",new ArrayList<MessageModel>()));
        usersList.add(new UsersModel("https://scontent.fevn2-1.fna.fbcdn.net/v/t1.0-9/300361_150382331717695_952750827_n.jpg?_nc_cat=0&oh=6ecf046117463d26dced452a0d8a0bbf&oe=5B9F3575", "Seyran Alaverdyan", "es nuyn@ C++ ov aveli heshta","---","salaver@bk.ru","17/11/1960",new ArrayList<MessageModel>()));

        return usersList;
    }
    public static UsersModel getUserByPosition(int position){
        return usersList.get(position);
    }
}