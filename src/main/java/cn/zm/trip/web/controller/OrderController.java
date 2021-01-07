package cn.zm.trip.web.controller;

import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.OrderService;
import cn.zm.trip.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ViewPointDao viewPointDao;
    @Autowired
    private HotelDao hotelDao;
    @Autowired
    private HttpSession session;


    /**
     * 跳转到订单显示页面
     * @return
     */
    @RequestMapping(value = "attractionsOrder",method = RequestMethod.GET)
    public String display1(String uid,Model model){
        List<AttractionOrder> list= orderService.getAtrractions(Integer.parseInt(uid));
        model.addAttribute("attractions",list);
        if(list.size()==0) return "proscenium/order/errorPage";
        return "proscenium/order/attractionsOrder";
    }

    @RequestMapping(value = "trafficsOrder",method = RequestMethod.GET)
    public String display2(String uid,Model model){
        List<TrafficOrder> list= orderService.getTraffics(Integer.parseInt(uid));
        model.addAttribute("traffics",list);
        if(list.size()==0) return "proscenium/order/errorPage";
        return "proscenium/order/trafficsOrder";
    }

    @RequestMapping(value = "hotelsOrder",method = RequestMethod.GET)
    public String display3(String uid,Model model){
        List<HotelOrder> list= orderService.getHotels(Integer.parseInt(uid));
        model.addAttribute("hotels",list);
        if(list.size()==0) return "proscenium/order/errorPage";
        return "proscenium/order/hotelsOrder";
    }

    /**
     * 跳转到订单页
     */
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public String orderPage(String key, String tpVid, String tpUid, Model model){
        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_time=df.format(d);

        //Integer.parseInt("aaa");

        String date=date_time.split(" ")[0].trim();
        String time=date_time.split(" ")[1].trim();
        String[] date_array=date.split("-");
        String[] time_array=time.split(":");
        String dt=date_array[0]+(date_array[1].length()<2? "0"+date_array[1]:date_array[1])+(date_array[2].length()<2? "0"+date_array[2]:date_array[2])+(time_array[0].length()<2? "0"+time_array[0]:time_array[0])+(time_array[1].length()<2? "0"+time_array[1]:time_array[1])+(time_array[2].length()<2? "0"+time_array[2]:time_array[2]);
//		System.out.println(dt);
        User user=userService.findUser(tpUid);
        if(user!=null){
            if(key.trim().equals("attraction")){ // 景点订单
                ViewPoint viewPoint=viewPointDao.selectByPrimaryKey(Integer.parseInt(tpVid));
                String oid="A"+dt+user.getPhone().trim().substring(7);
                AttractionOrder attractionOrder=new AttractionOrder();
                attractionOrder.setAttr_orderId(oid);
                attractionOrder.setAttr_uid(Integer.parseInt(tpUid));
                attractionOrder.setAttr_cost(Integer.parseInt(viewPoint.getTpPrice()));
                attractionOrder.setAttr_createDate(date);
                attractionOrder.setAttr_createTime(time);
                attractionOrder.setAttr_name(viewPoint.getTpVname());
                attractionOrder.setAttr_place(viewPoint.getTpLocation());
                attractionOrder.setAttr_uemail(user.getUemail());
                attractionOrder.setAttr_uphone(user.getPhone());

                attractionOrder.setAttr_vid(viewPoint.getTpVid());

                session.setAttribute("order",attractionOrder);
                return "proscenium/order/attractionContent";
//                return "test";
            }

            else if(key.trim().equals("hotel")){ //酒店订单
                Hotel hotel=hotelDao.selectByPrimaryKey(Integer.parseInt(tpVid));
                String oid="H"+dt+user.getPhone().trim().substring(7);
                HotelOrder hotelorder=new HotelOrder();
                hotelorder.setHotel_orderId(oid);
                hotelorder.setHotel_uid(Integer.parseInt(tpUid));
                hotelorder.setHotel_cost(Integer.parseInt(hotel.getPrice()));
                hotelorder.setHotel_createDate(date);
                hotelorder.setHotel_createTime(time);
                hotelorder.setHotel_name(hotel.getTitle());
                hotelorder.setHotel_place(hotel.getLocal());
                hotelorder.setHotel_uemail(user.getUemail());
                hotelorder.setHotel_uphone(user.getPhone());

                hotelorder.setHotel_hid(hotel.getHid());

                session.setAttribute("order",hotelorder);
                return "proscenium/order/hotelContent";
            }
            else{
                return "proscenium/order/trafficContent";
            }

        }
        else{ //用户未登录
            return "redirect:/index";
        }
    }

    /**
     * 订单生成
     */
    @RequestMapping(value = "commit",method = RequestMethod.POST)
    public String createOrder(String key, Model model, HttpServletRequest request){
//        System.out.println(booktime+"啊啊啊啊啊啊啊啊啊啊啊啊啊");
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"+key);
        String booktime=request.getParameter("booktime");
        if(key.trim().equals("attraction")){ // 景点订单
            AttractionOrder attractionOrder=(AttractionOrder)session.getAttribute("order");

            attractionOrder.setAttr_time(booktime.trim());
            System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"+attractionOrder.getAttr_time());
            String orderInfo="";
            session.setAttribute("order",attractionOrder);
            model.addAttribute("order",attractionOrder);
            orderInfo=attractionOrder.getAttr_name().trim()+"#"+attractionOrder.getAttr_place().trim()+"#"+attractionOrder.getAttr_uemail().trim()+"#"
                    +attractionOrder.getAttr_uphone().trim()+"#"+attractionOrder.getAttr_cost()+"#"+attractionOrder.getAttr_createDate().trim()+"#"
                    +attractionOrder.getAttr_createTime().trim()+"#"+attractionOrder.getAttr_time().trim()+"#"+attractionOrder.getAttr_vid().toString();
            orderService.insertOrder(attractionOrder.getAttr_orderId().trim(),attractionOrder.getAttr_uid(),orderInfo);
//            return "proscenium/order/attractionsOrder";
            List<AttractionOrder> list= orderService.getAtrractions(Integer.parseInt(request.getParameter("uid").trim()));
            model.addAttribute("attractions",list);
            if(list.size()==0) return "proscenium/order/errorPage";
            return "proscenium/order/attractionsOrder";
//            return "forward:views/proscenium/user/attractionsOrder.jsp";
        }
        else if(key.trim().equals("hotel")){
            HotelOrder hotelOrder=(HotelOrder)session.getAttribute("order");
            hotelOrder.setHotel_time(booktime);
            String orderInfo="";
            session.setAttribute("order",hotelOrder);
            model.addAttribute("order",hotelOrder);
            orderInfo=hotelOrder.getHotel_name().trim()+"#"+hotelOrder.getHotel_place().trim()+"#"+hotelOrder.getHotel_uemail().trim()+"#"
                    +hotelOrder.getHotel_uphone().trim()+"#"+hotelOrder.getHotel_cost()+"#"+hotelOrder.getHotel_createDate().trim()+"#"
                    +hotelOrder.getHotel_createTime().trim()+"#"+hotelOrder.getHotel_time().trim()+"#"+hotelOrder.getHotel_hid().toString();
            orderService.insertOrder(hotelOrder.getHotel_orderId(),hotelOrder.getHotel_uid(),orderInfo);
//            return "proscenium/order/hotelsOrder";
            List<HotelOrder> list= orderService.getHotels(Integer.parseInt(request.getParameter("uid").trim()));
            model.addAttribute("hotels",list);
            if(list.size()==0) return "proscenium/order/errorPage";
            return "proscenium/order/hotelsOrder";
        }
        else{
            return "proscenium/order/trafficsOrder";
        }


    }



    /**
     * 订单删除
     */
    @RequestMapping(value = "orderDelete",method = RequestMethod.GET)
    public String deleteOrder(String tp_oid,String uid,Model model,HttpServletRequest request){
//        String tp_oid=request.getParameter("oid").trim().split(":")[1];
//        String uid=request.getParameter("uid").trim().split(":")[1];
        char type=tp_oid.charAt(0);
        orderService.deleteOrder(tp_oid);
        System.out.println("type="+type);
        //页面重新显示
        switch (type){
            case 'A':
                List<AttractionOrder> list_attr= orderService.getAtrractions(Integer.parseInt(uid));
                model.addAttribute("attractions",list_attr);
                System.out.println("attr.size="+list_attr.size());
                return list_attr.size()>0 ? "proscenium/order/attractionsOrder" : "proscenium/order/errorPage";
            case 'T':
                List<TrafficOrder> list_traf= orderService.getTraffics(Integer.parseInt(uid));
                for(TrafficOrder traf:list_traf)
                    model.addAttribute("traffics",list_traf);
                return list_traf.size()>0 ? "proscenium/order/trafficsOrder" : "proscenium/order/errorPage";
            case 'H':
                List<HotelOrder> list_hotel= orderService.getHotels(Integer.parseInt(uid));
                model.addAttribute("hotels",list_hotel);
                return list_hotel.size()>0 ? "proscenium/order/hotelsOrder" : "proscenium/order/errorPage";
            default:
                return "proscenium/order/errorPage";
        }

    }

    /**
     * 取消订单
     */
    @RequestMapping(value = "cancelSubmit",method = RequestMethod.GET)
    public String cancelOrder(){
        return "redirect:/index";
    }



}
