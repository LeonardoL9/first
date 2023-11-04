import request from '@/utils/request'

export default{

    //1讲师列表（条件查询分页）
    //current 当前页 limit 每页记录数  teacherQuery 条件对象
    getTeacherListPage(current,limit){
        return request({
            url: `/eduservice/teacher/pageTeacher/${current}/${limit}`,
            method: 'get',
            //teacherQuery条件对象，后端使用RequestBody获取数据
            //data表示把对象转换json进行传递到接口中
            
          })

    }


}

