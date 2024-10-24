import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import com.example.homeworkfromezis.CarModel
import com.example.homeworkfromezis.databinding.FragmentDeatilBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDeatilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeatilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getSerializable("key") as CarModel


        binding.img.load(data.img)
        binding.model.text = data.model
        binding.number.text = data.number
        binding.price.text = data.price.toString()
        binding.description.text = data.description

        binding.btnWa.setOnClickListener {
            val number = data.number.replace(" ", "")
            try {
                val uri = Uri.parse("https://wa.me/$number")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(context, "WhatsApp is not installed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.number.setOnClickListener {
            val number = data.number.replace(" ", "")
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:$number")
            startActivity(dialIntent)
        }
    }
}
