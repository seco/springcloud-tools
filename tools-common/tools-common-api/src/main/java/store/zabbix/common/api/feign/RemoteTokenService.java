/*
 *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package store.zabbix.common.api.feign;

import store.zabbix.common.api.feign.factory.RemoteTokenServiceFallbackFactory;
import store.zabbix.common.core.constant.SecurityConstants;
import store.zabbix.common.core.constant.ServiceNameConstants;
import store.zabbix.common.core.util.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@FeignClient(value = "tools-auth", fallbackFactory = RemoteTokenServiceFallbackFactory.class)
public interface RemoteTokenService {
	/**
	 * 分页查询token 信息
	 *
	 * @param params 分页参数
	 * @param from   内部调用标志
	 * @return page
	 */
	@PostMapping("/token/page")
	ResultBean getTokenPage(@RequestBody Map<String, Object> params, @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 删除token
	 *
	 * @param token token
	 * @param from  调用标志
	 * @return
	 */
	@DeleteMapping("/token/{token}")
	ResultBean<Boolean> removeToken(@PathVariable("token") String token, @RequestHeader(SecurityConstants.FROM) String from);
}